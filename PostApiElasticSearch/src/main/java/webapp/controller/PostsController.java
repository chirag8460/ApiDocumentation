package webapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import webapp.entity.Post;
import webapp.services.PostsService;

@RestController
@RequestMapping("/posts")
public class PostsController {

	@Autowired
	private PostsService postService;
	String url = "http://localhost:8090/loggers/";
	Post tempPost = new Post();
	ObjectMapper mapper = new ObjectMapper();
	String tempResponse;

	@GetMapping
	public List<Post> getPost(@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {
		//return startDate == null ? postService.getPosts() : postService.getPostsByDate(startDate, endDate);
		return postService.getPosts();
	}

	@GetMapping("/{id}")
	public Post getPost(@PathVariable int id) {
		return postService.getPosts(id);
	}

	@GetMapping("/{title}")
	public List<Post> getPostByTitle(@PathVariable String title) {
		return postService.getPostByTitle(title);
	}
	@PostMapping
	public ResponseEntity<?> addPost(@RequestBody Post post) throws JsonProcessingException {
		tempResponse = postService.addPost(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(tempResponse);
	}

	@PutMapping
	public ResponseEntity<?> updatePost(@RequestBody Post post) throws JsonProcessingException {
		String tempResponse = postService.updatePost(post);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tempResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeletePost(@PathVariable int id) throws JsonProcessingException {

		String tempResponse = postService.deletePost(id);
		return ResponseEntity.status(HttpStatus.OK).body(tempResponse + " a");
	}

}
