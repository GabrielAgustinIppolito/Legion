package org.generation.italy.legion.model.services.implementations;

import org.generation.italy.legion.model.entities.Course;
import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.legion.model.services.abstractions.AbstractDidacticService;

import java.util.List;
import java.util.Optional;

public class TestDidacticService implements AbstractDidacticService {
    @Override
    public List<Course> findAllCourses() throws DataException {
        return null;
    }

    @Override
    public Optional<Course> findCourseById(long id) throws DataException {
        return Optional.empty();
    }

    @Override
    public List<Course> findCoursesByTitleContains(String part) throws DataException {
        return null;
    }

    @Override
    public Course saveCourse(Course course) throws DataException {
        return null;
    }

    @Override
    public void updateCourse(Course course) throws EntityNotFoundException, DataException {

    }

    @Override
    public void deleteCourseById(long id) throws EntityNotFoundException, DataException {

    }

    @Override
    public boolean adjustActiveCourses(int numActive) throws DataException {
        return false;
    }
}
