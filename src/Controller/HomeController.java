package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.Status;
import DB.DBConnection;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = DB.DBConnection.CreateConnection();
		ArrayList<Status> list = DAO.StatusDAO.listStatus(conn);
		request.setAttribute("List", list);
		request.setAttribute("action", "");
		RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		String action = request.getParameter("action");

		if (action == null || action.equalsIgnoreCase("")) {
			ArrayList<Status> list = DAO.StatusDAO.listStatus(conn);
			request.setAttribute("List", list);
			RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
			rd.forward(request, response);
			return;
		}
		switch (action) {
		case "add": {
			try {
				//

				final int maxMemorySize = 1024 * 1024 * 20; // gioi hạn kich thuoc hinh anh la 20MB
				final int maxRequestSize = 1024 * 1024 * 50; // gioi hạn kich thuoc hinh anh la 50MB
				// Create a factory for disk-based file items
				// khoi tao vung nho tam luu file
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// Configure a repository (to ensure a secure temp location is used)
				ServletContext servletContext = this.getServletConfig().getServletContext();

				// thiet lap kich thuoc file
				factory.setSizeThreshold(maxMemorySize);

				File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repository);

				// Create a new file upload handler
				// chuyen file qua bo nho chinh khi kiem tra thanh cong
				ServletFileUpload upload = new ServletFileUpload(factory);

				// Parse the request
				// dua file vao trong 1 cai list
				List<FileItem> items = upload.parseRequest(request);

				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				HashMap<String, String> fields = new HashMap<String, String>();
				final String address = servletContext.getRealPath("/img");
				request.setAttribute("address", address);
				// hasNext kiem tra co file hay khong
				while (iter.hasNext()) {
					// iter.next() chuyen toi file do
					FileItem item = iter.next();

					// lam viec voi file && item.isFormField lam viet voi form
					if (!item.isFormField()) {
						// ghi file thanh cong

						// lay ten file
						String fileName = item.getName();
						// vi tri luu file
						boolean kt = false;
						File uploadFile = null;
						int i = 1;
						String pathFile = address + File.separator;
						String pathFileCopy = pathFile;
						System.out.println(servletContext.getRealPath("/img"));
						// kiem tra trung ten
						do {
							// upload File
							uploadFile = new File(pathFile + fileName);
							// kiem tra trung ten
							kt = uploadFile.exists();
							// neu trung ten thi them so vao
							pathFile = pathFileCopy + Integer.toString(i);
							i++;
						} while (kt);

						ArrayList<Status> list = DAO.StatusDAO.listStatus(conn);
						request.setAttribute("List", list);
						RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
						rd.forward(request, response);
						item.write(uploadFile);
					} else {
						// ghi file that bai

					}
				}
			} catch (Exception e) {
				e.addSuppressed(e);
			}
		}
			break;

		default:
			break;
		}
	}

}
