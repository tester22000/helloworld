package com.eastgrams.lottoresult.data.repository;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LottoDrawResultRepository extends JpaRepository<LottoDrawResult, Integer> {
    Optional<LottoDrawResult> findByDrwNo(int drwNo);
}
