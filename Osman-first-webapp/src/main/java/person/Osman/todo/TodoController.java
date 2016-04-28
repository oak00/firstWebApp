package person.Osman.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name") // Global variable
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value="/list-todos", method= RequestMethod.GET)
	public String listToDos(ModelMap model){
		model.addAttribute("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method= RequestMethod.GET)
	public String showToDoPage(ModelMap model){
		model.addAttribute("todo",new Todo(0,"in28Minutes","",new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method= RequestMethod.POST)
	public String addToDo(ModelMap model, @Valid Todo todo, BindingResult result ){
		if(result.hasErrors()){ //Validation
			return "todo";
		}
		service.addTodo("in28Minutes", todo.getDesc(), new Date(), false);
		model.clear(); //removes session values from url
		return "redirect:list-todos"; // redirects to /list-todos page with established model
	}
	
	@RequestMapping(value="/delete-todo", method= RequestMethod.GET)
	public String deleteToDo(ModelMap model, @RequestParam int id){
		service.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/update-todo", method= RequestMethod.GET)
	public String updateToDo(ModelMap model, @RequestParam int id){
		Todo todo = service.retrieveTodo(id);
		model.clear();
		model.addAttribute("todo", todo);

		return "todo";
	}	
	
	@RequestMapping(value="/update-todo", method= RequestMethod.POST)
	public String updateToDo(ModelMap model, @Valid Todo todo, BindingResult result ){
		if(result.hasErrors()){ //Validation
			return "todo";
		}
		todo.setUser("in28Minutes");
		model.clear();
		service.updateTodo(todo);
		return "redirect:list-todos";
	}	
	

}
	
