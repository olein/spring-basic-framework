package jonak.testspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml");

		NoticesDAO noticesDAO = (NoticesDAO) context.getBean("noticesDAO");
		try {
			/*create new entry*/
			Notice newnotice1 = new Notice(16, "Rony1","ronycseju1@gmail.com","where am i?");
			Notice newnotice2 = new Notice(21, "Rony2","ronycseju2@gmail.com","where am i?");
			Notice newnotice3 = new Notice(31, "Rony3","ronycseju3@gmail.com","where am i?");
			
			List<Notice> noticeList = new ArrayList<Notice>();
			noticeList.add(newnotice1);
			noticeList.add(newnotice2);
			noticeList.add(newnotice3);
			noticesDAO.creat(noticeList);
			//noticesDAO.update(newnotice);
			//noticesDAO.create(newnotice);
			
			List<Notice> notices = noticesDAO.getNotices();

			for (Notice notice : notices) {
				System.out.println(notice);
			}

			Notice notice = noticesDAO.getNotices(3);
			System.out.println("Next notice by id: " + notice);
			
			/*delete entry*/
//			boolean result = noticesDAO.deleteById(4);
//			System.out.println("Deleted : " + result);
			
			
			
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
