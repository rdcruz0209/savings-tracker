package com.rdcruz.savingstracker.controller;

import com.rdcruz.savingstracker.domain.dto.TransactionXmlDto;
import com.rdcruz.savingstracker.domain.entity.Transaction;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;
import com.rdcruz.savingstracker.service.TransactionService;
import com.rdcruz.savingstracker.service.XmlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarException;


@RestController
@RequestMapping(path = "/v1/transaction")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionService transactionServiceImpl;
    private final XmlService xmlServiceImpl;

    @Operation(description = "Find all Transaction")
    @GetMapping("/")
    public ResponseEntity<List<Transaction>> findAllTransaction() {
        return new ResponseEntity<>(transactionServiceImpl.findAllTransaction(), HttpStatus.OK);
    }

    @GetMapping("/findAllTransactionsByType")
    public ResponseEntity<List<Transaction>> findAllTransactionByType(@RequestParam TypeEnum type) {
        return new ResponseEntity<>(transactionServiceImpl.findAllTransactionByType(type), HttpStatus.OK);
    }

    @Operation(description = "Find a Transaction using id")
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findTransactionById(@PathVariable String id) {
        if (Objects.isNull(transactionServiceImpl.findById(id))) {
            return ResponseEntity.notFound()
                                 .build();
        } else {
            return new ResponseEntity<>(transactionServiceImpl.findById(id), HttpStatus.OK);
        }
    }


    @Operation(summary = "Create XML representation of transaction by ID",
            description = "Creates an XML representation of a transaction by its ID.")
    @GetMapping(value = "/createTransactionXmlById")
//    @GetMapping(value = "/createTransactionXmlById", produces = "application/xml")
//    @ApiResponse(responseCode = "200", description = "Successful operation",
//            content = @Content(mediaType = "application/xml",
//                    schema = @Schema(implementation = TransactionXmlDto.class)))
    public ResponseEntity<String> createTransactionXmlById(@RequestParam String id) throws JAXBException {
        try {
            if (Objects.isNull(transactionServiceImpl.findById(id))) {
                return ResponseEntity.notFound()
                                     .build();
            } else {
                return new ResponseEntity<>(xmlServiceImpl.createXml(transactionServiceImpl.findById(id)), HttpStatus.OK);
            }
        }
        catch (JAXBException je){
            throw new JAXBException(je);
        }
    }

    @Operation(description = "Delete a Transaction using id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionById(@PathVariable String id) {
        transactionServiceImpl.deleteTransactionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(description = "Save a Transaction record to the database")
    @PostMapping("/")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionServiceImpl.saveTransaction(transaction));
    }

    @PostMapping("/createTransaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionServiceImpl.createTransaction(transaction));
    }

    @PatchMapping("/updateTransaction")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @RequestParam String id) {
        return ResponseEntity.ok(transactionServiceImpl.updateTransaction(transaction, id));
    }

//    @GetMapping("/testMp3")
//    public ResponseEntity<String> getMp3Title(@RequestParam String path){
//        try {
//            Path filePath = Paths.get(path);
//            log.info("{}",filePath.toString());
//            Mp3File mp3File = new Mp3File(filePath);
//            ID3v2 id3v2tag = mp3File.getId3v2Tag();
//            log.info(id3v2tag.getDate());
//            return id3v2tag != null? ResponseEntity.ok(id3v2tag.getAlbumArtist()):null;
//        } catch (InvalidDataException | UnsupportedTagException | IOException e) {
//            String stackTrace = Arrays.stream(e.getStackTrace())
//                                      .map(StackTraceElement::toString)
//                                      .collect(Collectors.joining("\n"));
//            return ResponseEntity.internalServerError().body(Arrays.toString(e.getStackTrace()));
//        }
//    }

}
