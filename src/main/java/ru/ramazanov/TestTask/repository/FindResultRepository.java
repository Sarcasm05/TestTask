package ru.ramazanov.TestTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ramazanov.TestTask.domain.FindResultEntity;

@Repository
public interface FindResultRepository extends JpaRepository<FindResultEntity, Long> {

}
