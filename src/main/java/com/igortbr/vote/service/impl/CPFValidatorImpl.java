package com.igortbr.vote.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.igortbr.vote.enums.TypePermission;

@Service
public class CPFValidatorImpl {

    public boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            return false;
        }

        int[] cpfArray = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += cpfArray[i] * (10 - i);
            sum2 += cpfArray[i] * (11 - i);
        }

        int checkDigit1 = (sum1 * 10) % 11;
        if (checkDigit1 == 10) {
            checkDigit1 = 0;
        }

        sum2 += checkDigit1 * 2;
        int checkDigit2 = (sum2 * 10) % 11;
        if (checkDigit2 == 10) {
            checkDigit2 = 0;
        }

        return checkDigit1 == cpfArray[9] && checkDigit2 == cpfArray[10];
    }

    public TypePermission checkVotingEligibility(String cpf) {
        if (!isValidCPF(cpf)) {
            return TypePermission.UNABLE_TO_VOTE;
        }

        boolean canVote = new Random().nextBoolean();

        if (canVote) {
            return TypePermission.ABLE_TO_VOTE;
        } else {
            return TypePermission.UNABLE_TO_VOTE;
        }
    }
}