package com.zygstore.utils;

import com.zygstore.excpetions.WrongIdException;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class IdGenerator {
    public static final Long MINIMUM_START_ID = 1L;
    private Long id;

    public IdGenerator() {
        this.id = MINIMUM_START_ID;
    }

    public IdGenerator(Long startId) throws WrongIdException {
        if (startId < MINIMUM_START_ID) {
            throw new WrongIdException(String.format("StartId cannot be less than %d", MINIMUM_START_ID));
        }

        this.id = startId;
    }

    public Long generateNewId() {
        return id++;
    }

    public Long getId() {
        return id;
    }
}
