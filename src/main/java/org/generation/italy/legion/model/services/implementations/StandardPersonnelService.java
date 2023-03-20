package org.generation.italy.legion.model.services.implementations;

import org.generation.italy.legion.model.data.abstractions.TeacherRepository;
import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.generation.italy.legion.model.services.abstractions.AbstractDidacticService;
import org.generation.italy.legion.model.services.abstractions.AbstractionPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StandardPersonnelService implements AbstractionPersonnelService {
   private TeacherRepository repo;
   @Autowired
   public StandardPersonnelService(TeacherRepository repo){
      this.repo=repo;
   }

   @Override
   public List<Teacher> findAll() throws DataException {
      return repo.findAll();
   }

   @Override
   public Optional<Teacher> findById(long id) throws DataException {
      return repo.findById(id);
   }

   @Override
   public Teacher create(Teacher teacher) throws DataException {
      return repo.create(teacher);
   }

   @Override
   public void update(Teacher teacher) throws EntityNotFoundException, DataException {
      repo.update(teacher);
   }

   @Override
   public void deleteById(long id) throws EntityNotFoundException, DataException {
      repo.deleteById(id);
   }

   @Override
   public Iterable<Teacher> findWithCompetenceByLevel(Level teacherLevel) throws DataException {
      return repo.findWithCompetenceByLevel(teacherLevel);
   }

   @Override
   public Iterable<Teacher> findWithSkillAndLevel(long idSkill, Level competenceLevel) {
      return repo.findWithSkillAndLevel(idSkill, competenceLevel);
   }

   @Override
   public Iterable<Teacher> findTeachersByNCourseEdition(int n) {
      return repo.findTeachersByNCourseEdition(n);
   }
}
