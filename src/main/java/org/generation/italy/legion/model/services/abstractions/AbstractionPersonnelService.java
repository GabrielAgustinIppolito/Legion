package org.generation.italy.legion.model.services.abstractions;

import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

import static org.generation.italy.legion.model.data.HibernateConstants.*;

public interface AbstractionPersonnelService {
   public List<Teacher> findAll() throws DataException;

   public Optional<Teacher> findById(long id) throws DataException;

   public Teacher create(Teacher teacher) throws DataException;

   public void update(Teacher teacher) throws EntityNotFoundException, DataException;

   public void deleteById(long id) throws EntityNotFoundException, DataException;
   public Iterable<Teacher> findWithCompetenceByLevel(Level teacherLevel) throws DataException;
   public Iterable<Teacher> findWithSkillAndLevel(long idSkill, Level competenceLevel);
   public Iterable<Teacher> findTeachersByNCourseEdition(int n);

}