package webapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.entity.Logger;
import webapp.entity.Post;
import webapp.repository.postsRepository;

@Service
public class PostsService {

	@Autowired
	private postsRepository postRepository;
	RestTemplate restTemplate = new RestTemplate();
	Post tempPost = new Post();
	String url = "http://localhost:9050/logs/";
	Logger tempLogger = new Logger();
	ObjectMapper mapper = new ObjectMapper();
	Date date = new Date();
	String jsonStringPost;
	String jsonStringLogger;
	String beforeSnapshot;
	String afterSnapshot;

	public List<Post> getPosts() {
		List<Post> posts = new ArrayList<>();
		for (Post post : postRepository.findAll()) {
			posts.add(post);
		}
		return posts;
	}

	public Post getPosts(int id) {
		return postRepository.findById(id).get();

	}

	public String addPost(Post post) throws JsonProcessingException {
		postRepository.save(post);
		jsonStringPost = mapper.writeValueAsString(post);
		tempLogger.setAfterSnapshot(jsonStringPost);
		tempLogger.setBeforeSnapshot(jsonStringPost);
		// hard-coded require some code to get actual users
		tempLogger.setEntityName("Post");
		tempLogger.setAction("insert");
		tempLogger.setUserId(post.getId() + "");
		tempLogger.setId(post.getId() + 1000);
		tempLogger.setCreatedDate(new Date());
		tempLogger.setFirstName("Adam");
		tempLogger.setLastName("Smith");
		tempLogger.setUserName("adam_smith72");

		tempLogger = restTemplate.postForObject(url, tempLogger, Logger.class);
		jsonStringLogger = mapper.writeValueAsString(tempLogger);
		return "Post Object -> " + jsonStringPost + "  Logger Object -> " + jsonStringLogger;

	}

	public String updatePost(Post post) throws JsonProcessingException {
		// beforeSavingData
		tempPost = this.getPosts(post.getId());
		beforeSnapshot = mapper.writeValueAsString(tempPost);
		postRepository.save(post);

		// AfterSavingData
		afterSnapshot = mapper.writeValueAsString(this.getPosts(post.getId()));
		tempLogger.setId(post.getId()+2000);
		tempLogger.setEntityName("Post");
		tempLogger.setCreatedDate(new Date());
		tempLogger.setBeforeSnapshot(beforeSnapshot);
		tempLogger.setAfterSnapshot(afterSnapshot);
		tempLogger.setUserId(""+post.getId());
		tempLogger.setAction("update");
		tempLogger.setFirstName("Richard");
		tempLogger.setLastName("Herrison");
		tempLogger.setUserName("Richard_Herrison");

		tempLogger = restTemplate.postForObject(url, tempLogger, Logger.class);
		jsonStringLogger = mapper.writeValueAsString(tempLogger);
		return "Post Object -> " + beforeSnapshot + "Logger Object -> " + jsonStringLogger;

	}

	public String deletePost(int id) throws JsonProcessingException {
		tempPost = this.getPosts(id);
		beforeSnapshot = mapper.writeValueAsString(tempPost);
		postRepository.deleteById(id);
		tempLogger.setBeforeSnapshot(beforeSnapshot);
		tempLogger.setAfterSnapshot("Delete Request Invoked");
		tempLogger.setEntityName("Post");
		tempLogger.setAction("delete");
		tempLogger.setUserId("" + id);
		
		tempLogger.setId(tempPost.getId()+3000);
		tempLogger.setCreatedDate(new Date());
		tempLogger.setFirstName("Douglas");
		tempLogger.setLastName("Smith");
		tempLogger.setUserName("adam_smith72");

		tempLogger = restTemplate.postForObject(url, tempLogger, Logger.class);
		jsonStringLogger = mapper.writeValueAsString(tempLogger);
		return "Post Object -> " + beforeSnapshot + " Logger Object -> " + jsonStringLogger;
	}

	public List<Post> getPostsByDate(String startDate, String endDate) {
		List<Post> posts = new ArrayList<>();
		try {
			for (Post post : postRepository.findAllByCreatedDate(new SimpleDateFormat("yyyy-MM-dd").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd").parse(endDate))) {
				posts.add(post);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return posts;
	}

	public void migrateData() {
		List<Post> posts = new ArrayList<>();
		for (Post post : postRepository.findAll()) {
			posts.add(post);
			tempLogger = restTemplate.postForObject(url, post, Logger.class);
		}

	}

	public String addMultiplePost(List<Post> post) throws JsonProcessingException {
		for (Post tempPost : post) {			
		postRepository.save(tempPost);
		jsonStringPost = mapper.writeValueAsString(tempPost);
		tempLogger.setAfterSnapshot(jsonStringPost);
		tempLogger.setBeforeSnapshot(jsonStringPost);
		// hard-coded -> requires some code to get actual users
		tempLogger.setEntityName("Session");
		tempLogger.setAction("Insert");
		tempLogger.setUserId(tempPost.getId() + "");
		tempLogger.setId(tempPost.getId() + 100);
		tempLogger.setFirstName("John");
		tempLogger.setLastName("wick");
		tempLogger.setUserName("john_wick72");
		tempLogger.setCreatedDate(tempPost.getCreatedDate());		
		tempLogger = restTemplate.postForObject(url, tempLogger, Logger.class);
		jsonStringLogger = mapper.writeValueAsString(tempLogger);
		}
		return "success";
	}

}