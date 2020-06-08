package ar.com.francis.xmen.controllers;

import ar.com.francis.xmen.models.request.RequestMutant;
import ar.com.francis.xmen.models.response.ResponseMutant;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import ar.com.francis.xmen.service.ResponseService;

/**
 * Controlador para consultar su un humano es mutante por medio de su secuencia
 * de ADN.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class LambdaHandlerMutant implements RequestHandler<RequestMutant, ResponseMutant> {

    @Override
    public ResponseMutant handleRequest(RequestMutant request, Context cntxt) {

        ResponseService responseService = InstantApp.resolveServiceResponse();

        return responseService.getResponseMutant(request.getDna());
    }

}
