package cl.praxis.JdbcRental.controller;

import cl.praxis.JdbcRental.dto.Film;
import cl.praxis.JdbcRental.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmController {

  FilmService service;

  public FilmController(FilmService service) {
    this.service = service;
  }

  @GetMapping
  public String findAll(Model model){
    model.addAttribute("films", service.findAll());
    return "filmsList";
  }
  @GetMapping("/{id}")
  public String findOne(@PathVariable("id") int id, Model model){
    model.addAttribute("film", service.findOne(id));

    return "filmEdit";
  }

  @PostMapping
  public String update(@ModelAttribute Film film){
    boolean result = service.update(film);

    return "redirect:/films";
  }

  @GetMapping("/new")
  public String toCreate(){
    return "filmNew";
  }

  @PostMapping("/new")
  public String create(@ModelAttribute Film film){
    boolean result = service.create(film);

    return "redirect:/films";
  }

  @GetMapping("/{id}/del")
  public String delete(@PathVariable("id") int id){
    boolean reuslt = service.delete(id);

    return "redirect:/films";
  }

}
