package org.generation.italy.legion.controllers;

import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.generation.italy.legion.model.services.abstractions.AbstractionPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {
   private AbstractionPersonnelService service;

   @Autowired
   public TeacherController(AbstractionPersonnelService service){
      this.service = service;
   }

   @GetMapping("/allTeachers")
   public String showTeachers (Model m){
      try {
         List<Teacher> teacherList = service.findAll();
         m.addAttribute("teachers", teacherList);
         return "teachers";    //nome della pagina (view) che uso per mostrare i dati all'utente
      } catch (DataException e) {
         e.printStackTrace();
         m.addAttribute("error", e.getCause().getMessage());
         return "error";
      }
   }
   @GetMapping("/teacherBySkillAndLevel")
   public String showFindTeacherBySL(){
      return "find_teacher_skill_level";
   }
   @GetMapping("/findTeacherBySkillAndLevel")
   public String findTeacherBySL(Model m, Long skillId, Level compLevel) {
      Iterable<Teacher> teachers = service.findWithSkillAndLevel(skillId, compLevel);
      List<Teacher> lt = new ArrayList<>();
      teachers.forEach(lt::add);
      m.addAttribute("teachersAndSkillAtLevel", lt);
      return "find_teacher_skill_level";
   }

}
