package ar.com.francis.xmen.controllers;

import ar.com.francis.xmen.eao.XmenFacade;
import ar.com.francis.xmen.service.impl.MutantServiceImpl;
import ar.com.francis.xmen.service.impl.ResponseServiceImpl;

/**
 * Realiza la función de service locator.
 *
 * @author Francisco M. Viola mailto:francimviola@gmail.com
 */
public final class InstantApp {

    public static ResponseServiceImpl resolveServiceResponse() {

        return new ResponseServiceImpl(new MutantServiceImpl(), resolveFacade());
    }

    public static XmenFacade resolveFacade() {

        return new XmenFacade();
    }
}
