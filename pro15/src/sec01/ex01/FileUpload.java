package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doHandle(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		// ���ε� �� ���� ��� ����
		File currentDirPath = new File("C:\\file_repo");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ���� ��� ����
		factory.setRepository(currentDirPath);
		// �ִ� ���ε� ������ ���� ũ�� ����
		factory.setSizeThreshold(1024 * 1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i =0; i <items.size();i ++) {
				// ���ε�� �׸���� �ϳ��� ������
				FileItem fileItem = (FileItem) items.get(i);
				
				// �� �ʵ�� ���۵� �Ű����� ���� ���
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
				} else {
					System.out.println("�Ķ���͸�:" + fileItem.getFieldName());
					System.out.println("���ϸ�:" + fileItem.getName());
					System.out.println("����ũ��:" + fileItem.getSize()+ "bytes");
					
					// �����ϴ� ������ �ִٸ�
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\"); // ������ ���
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					}
					
				}
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
