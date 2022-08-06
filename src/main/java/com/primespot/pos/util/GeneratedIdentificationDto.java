package com.primespot.pos.util;

import lombok.*;

//To get an ID
 /* Structure of ID
         --> For customer - ABED-C-123456789
         --> For employer - ABED-E-123456789
         --> For item     - ABED-I-123456789
         --> For order    - ABED-O-123456789 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneratedIdentificationDto {
   private Long id;
   private String prefix;
}
