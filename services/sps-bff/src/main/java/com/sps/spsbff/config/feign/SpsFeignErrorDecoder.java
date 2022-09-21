package com.sps.spsbff.config.feign;

import com.sps.spsbff.exceptions.BadRequestException;
import com.sps.spsbff.exceptions.InternalServerErrorException;
import com.sps.spsbff.exceptions.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class SpsFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new BadRequestException();
            case 404 -> new NotFoundException();
            default -> new InternalServerErrorException();
        };
    }

}
