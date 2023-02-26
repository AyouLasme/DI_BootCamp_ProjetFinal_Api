package com.api.taylor;

import com.api.taylor.controllers.CCustomers;
import com.api.taylor.controllers.CTaylors;
import com.api.taylor.controllers.CUsers;
import com.api.taylor.models.TCustomers;
import com.api.taylor.models.TTaylors;
import com.api.taylor.models.TUsers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.api.taylor.modules.Module.createDate;


@SpringBootApplication
public class TaylorApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(TaylorApplication.class, args);
		/*TUsers user1 = new TUsers(0,
				"ayou",
				"lasme",
				"ayou.lasme@gmail.com",
				"0895678334",
				"h,hqd",
				createDate("2010-12-20"),
				false,
				false,
				true,
				"F");


		TCustomers customer1 = new TCustomers(
				0,
				"MIA",
				"Kayla",
				"mi.lou@gmail.com",
				"083458334",
				"h,YJd",
				createDate("2016-10-10"),
				false,
				 true,
				false,
				"m");


		TTaylors taylor1 = new TTaylors(
				0,
				"MIA",
				"Kayla",
				"mi.lou@gmail.com",
				"083458334",
				"h,YJd",
				createDate("2010-03-22"),
				false,
				true,
				false,
				"m",
				"styliste",
				"mes_realisations");


		new CUsers().save(user1);
		new CTaylors().save(taylor1);
		new CCustomers().save(customer1);
		*/



	}


}
