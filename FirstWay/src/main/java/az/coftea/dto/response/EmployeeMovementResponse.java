package az.coftea.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
// This is just example
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeMovementResponse {
    private int id;
    private Date enterDate;
    private Date exitDate;
    private int idUserInsert;
    private Date insertDate;
    private short isActive;
    private int idEmployee;
    private int idWorkPeriod;

}