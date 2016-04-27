package person.Osman.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name") // Global variable
public class TodoController {
	
	@Autowired
	TodoService service;

	@RequestMapping(value="/list-todos", method= RequestMethod.GET)
	public String listToDos(ModelMap model){
		model.addAttribute("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method= RequestMethod.GET)
	public String showToDoPage(){
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method= RequestMethod.POST)
	public String addToDo(ModelMap model, @RequestParam String desc){
		service.addTodo("in28Minutes", desc, new Date(), false);
		model.clear(); //removes session values from url
		
		//changes URL to /list-todos rather than moving directly to list-todos.jsp
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method= RequestMethod.GET)
	public String deleteToDo(ModelMap model, @RequestParam int id){
		service.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}
	
	

}
	
