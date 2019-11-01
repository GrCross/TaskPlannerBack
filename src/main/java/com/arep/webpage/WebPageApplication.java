package com.arep.webpage;

import com.arep.webpage.config.JwtFilter;
import com.arep.webpage.config.appMongoConfiguration;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebPageApplication {

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/taskPlanner/users/*");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebPageApplication.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(appMongoConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
		mongoOperation.dropCollection(User.class);
		mongoOperation.dropCollection(Task.class);
		mongoOperation.insert(fillUsers(), User.class);
		mongoOperation.insert(fillTasks(), Task.class);
	}

	private static List<User> fillUsers(){

		List<User> users = new ArrayList<User>();

		User user1 = new User("ant","ant@m.com", "ant");
		User user2 = new User( "bird","bidr@m.com", "bird");
		User user3 = new User( "cat","cat@m.com", "cat");
		User user4 = new User( "dog","dog@m.com", "dog");
		User user5 = new User( "elephant","elephant@m.com","elephant");
		User user6 = new User( "frog","frog@m.com", "frog");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);

		return users;
	}

	private static List<Task> fillTasks(){

		List<Task> tasks = new ArrayList<Task>();

		Task task1 = new Task(1,"antTask1",1,"10/09/2019", "ant@m.com");
		Task task2 = new Task(2,"antTask2",2,"10/09/2019", "ant@m.com");
		Task task3 = new Task(3,"catTask",3,"10/09/2019", "cat@m.com");
		Task task4 = new Task(4,"dogTask",2,"10/09/2019", "dog@m.com");
		Task task5 = new Task(5,"elephantTask",1,"10/09/2019","elephant@m.com");
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		tasks.add(task5);
		return tasks;
	}

}
