package net.ycod3r.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ycod3r.domain.Periode;



public interface PeriodeRepo extends JpaRepository<Periode, Long> {

}
