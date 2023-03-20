package org.generation.italy.legion.controllers;

import jakarta.validation.Valid;
import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.entities.Course;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.generation.italy.legion.model.services.abstractions.AbstractDidacticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller //Definisce questa classe come un Controller
public class CourseController {
   private AbstractDidacticService service;
   @Autowired //Spring chiama questo costruttore, chiamato dal dispatcher che crea un oggetto da questa classe
   public CourseController(AbstractDidacticService service){
      this.service = service;
   }

   @GetMapping("/home")
   public String home(){
      return "home";
   }
   @GetMapping("/courses")
   public String showCourses (Model m){
      try {
         List<Course> courseList = service.findAllCourses();
         m.addAttribute("courses", courseList);
         return "courses";    //nome della pagina (view) che uso per mostrare i dati all'utente
      } catch (DataException e) {
         e.printStackTrace();
         m.addAttribute("error", e.getCause().getMessage());
         return "error";
      }
   }
   @GetMapping("/findCourseById")
   public String findById(Model m, long courseId){
      try {
         Optional<Course> c = service.findCourseById(courseId);
         Course found = c.orElse(new Course());
         m.addAttribute("course", found);
         return "course_detail";
      } catch (DataException e) {
         e.printStackTrace();
         m.addAttribute("error", e.getCause().getMessage());
         return "error";
      }
   }
   @GetMapping("/addNewCourse")
   public String showForm(){
      return "new_course";
   }

//   @GetMapping("/addNewCourse")
//   public String createCourse(Model m, String title, String description, String program, double duration,
//                              boolean isActive, LocalDate createdAt){
//      try {
//         Course course = new Course(title, description, program, duration, isActive, createdAt);
//         course = service.saveCourse(course);
//         m.addAttribute("course", course);
//         List<Course> courseList = service.findAllCourses();
//         m.addAttribute("courses", courseList);
//         return "new_course";                          //alternativa easy
//      } catch (DataException e) {
//         e.printStackTrace();
//         m.addAttribute("error", e.getCause().getMessage());
//         return "error";
//      }
//   }
@PostMapping("/newCourse")
public String createCourse(Model m, @Valid Course c, BindingResult result){
   try {
      if (result.hasErrors()){
         return "new_course";
      }
      c = service.saveCourse(c);
      return "redirect:/courses";
   } catch (DataException e) {
      e.printStackTrace();
      m.addAttribute("error", e.getCause().getMessage());
      return "error";
   }
}
   @GetMapping("/findByTitle")
   public String findByTitleLike(Model m, String part){
      try {
         List<Course> lc = service.findCoursesByTitleContains(part);
         m.addAttribute("courses", lc);
         return "find_by_title_like";
      } catch (DataException e) {
         e.printStackTrace();
         m.addAttribute("error", e.getCause().getMessage());
         return "error";
      }
   }

}
