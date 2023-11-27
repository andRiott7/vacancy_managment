package com.andriott.vacancy_managment.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.andriott.vacancy_managment.modules.candidate.CandidateRepository;
import com.andriott.vacancy_managment.modules.candidate.dto.ProfileCandidateResponseDTO;
import com.andriott.vacancy_managment.modules.candidate.dto.ProfileCandidateResponseDTO.ProfileCandidateResponseDTOBuilder;

@Service
public class ProfileCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  public ProfileCandidateResponseDTOBuilder execute(UUID idCandidate) {
    var candidate = this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
          throw new UsernameNotFoundException("User not found");
        });

    var candidateDTO = ProfileCandidateResponseDTO.builder()
        .description(candidate.getDescription())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .id(candidate.getId());

    return candidateDTO;
  }
}
