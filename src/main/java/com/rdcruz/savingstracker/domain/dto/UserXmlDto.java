package com.rdcruz.savingstracker.domain.dto;

import com.rdcruz.savingstracker.domain.entity.User;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name = "transaction")
@XmlType(propOrder = {"userId", "firstName", "lastName", "userName"})
public class UserXmlDto {
    String userId;
    String firstName;
    String lastName;
    String userName;
}