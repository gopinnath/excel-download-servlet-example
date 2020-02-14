package ind.gopinnath.example.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ind.gopinnath.example.entity.EmployeeEntity;
import ind.gopinnath.example.repository.EmployeeRepository;

@Service
public class ExportService {
	
	private final Logger logger = Logger.getLogger(ExportService.class.getName());
	
	@Autowired
	private EmployeeRepository repo;
	
	public void renderHtml(OutputStream out) throws IOException	{
		logger.info("Inside Service");
		List<EmployeeEntity> employees = repo.findAll();
		populateExcel(employees,out);
	}
	
	private void populateRow(EmployeeEntity employee,StringBuilder contentBuilder)	{
		contentBuilder.append("<tr><td>").append(employee.getEmployeeId());
		contentBuilder.append("</td><td>").append(employee.getFirstName());
		contentBuilder.append("</td><td>").append(employee.getLastName());
		contentBuilder.append("</td><td>").append(employee.getDesingation());
		contentBuilder.append("</td></tr>");
	}
	
	private void populateExcel(List<EmployeeEntity> employees,OutputStream out) throws IOException	{
		if(!employees.isEmpty())	{
			StringBuilder contentBuilder = new StringBuilder();
			contentBuilder.append("<html><head></head><body><table>");
			contentBuilder.append("<thead><td>Employee Id</td>");
			contentBuilder.append("<td>Employee First Name</td>");
			contentBuilder.append("<td>Employee Last Name</td>");
			contentBuilder.append("<td>Employee Desgination</td></thead>");
			employees.forEach(employee -> populateRow(employee,contentBuilder));
			contentBuilder.append("</table></body></html>");
			out.write(contentBuilder.toString().getBytes());
		}
	}
}
