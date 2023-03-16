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
	}


}
