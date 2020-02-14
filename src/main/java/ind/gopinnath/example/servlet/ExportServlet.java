package ind.gopinnath.example.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ind.gopinnath.configuration.Application;
import ind.gopinnath.example.service.ExportService;

@WebServlet(urlPatterns = { "/export" })
public class ExportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Logger logger = Logger.getLogger(ExportServlet.class.getName());

	private ExportService service;

	@Override
	public void init() throws ServletException {
		super.init();
		this.service = Application.getContext().getBean(ExportService.class);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (OutputStream out = response.getOutputStream();) {
			logger.info("Inside Servlet");

			// Set Header for download the content as Excel Disposable File
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "inline; filename=\"formattedExcelReport.xls\"");

			this.service.renderHtml(out);
			out.flush();
		}
	}
}
