package ar.com.francis.xmen.controllers;

import ar.com.francis.xmen.models.request.RequestStats;
import ar.com.francis.xmen.models.response.ResponseStats;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import ar.com.francis.xmen.service.ResponseService;

/**
 * Controlador para obtener el ratio de mutantes consultados.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public class LambdaHandlerStats implements RequestHandler<RequestStats, ResponseStats> {

    @Override
    public ResponseStats handleRequest(RequestStats request, Context cntxt) {

        ResponseService responseService = InstantApp.resolveServiceResponse();

        return responseService.getResponseStats();
    }

}
