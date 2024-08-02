package cl.praxis.JdbcRental.controller;

import cl.praxis.JdbcRental.dto.Actor;
import cl.praxis.JdbcRental.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actors")
public class ActorController {

  ActorService service;

  public ActorController(ActorService service) {
    this.service = service;
  }

  @GetMapping
  public String findAll(Model model){
    model.addAttribute("actors", service.findAll());
    return "actorList";
  }

  @GetMapping("/filter")
  public String findByName(
          @RequestParam(name="firstName", required = false) String firstName,
          Model model){

    model.addAttribute("actors", service.findByName(firstName));
    model.addAttribute("firstName", firstName);

    return "actorList";
  }

  @GetMapping("/{id}")
  public String findOne(@PathVariable("id") int id, Model model){
    model.addAttribute("actor", service.findOne(id));
    return "actorEdit";
  }

  @PostMapping
  public String update(@ModelAttribute Actor actor){
    boolean result = service.update(actor);
    return "redirect:/actors";
  }

  @GetMapping("/new")
  public String newActor(){
    return "actorNew";
  }

  @PostMapping("/new")
  public String create(@ModelAttribute Actor actor){
    boolean result = service.create(actor);
    return "redirect:/actors";
  }

  @GetMapping("/{id}/del")
  public String delete(@PathVariable("id") int id){
    boolean result = service.delete(id);
    return "redirect:/actors";
  }


}
