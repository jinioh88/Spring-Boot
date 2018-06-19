package com.example.boot4.persistence;

import com.example.boot4.domain.PDSBoard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PDSBaordRepository extends CrudRepository<PDSBoard,Long> {
    @Modifying
    @Query("update from PDSFile f set f.pdsfile = ?2 where f.fno = ?1")
    int updatePDSFile(Long fno, String newFileName);

    @Modifying
    @Query("delete from PDSFile f where f.fno = ?1")
    public int deletePDSFile(Long fno);
}
