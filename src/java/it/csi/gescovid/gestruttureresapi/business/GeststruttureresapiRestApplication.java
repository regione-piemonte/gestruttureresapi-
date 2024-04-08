/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import it.csi.gescovid.gestruttureresapi.business.be.impl.AssistenzaMedicaApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.DecodificaApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.DecorsoApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.EnteApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.FileApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.MovimentoApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.MovimentoOspiteApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RendicontazioneApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RendicontazioneBandiApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RichiestaTamponeApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RichiesteIntegrazioneBandiApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaDecessiApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaOspitiApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaPersonaleApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaPersonaleTipoApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaPostiApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaStrutturaNoteApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaTamponeApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaTamponeCategoriaApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaTipoTamponeApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaVisitatoriApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.RsaVisitatoriIngressiApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.SoggettiApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.StrutturaCategoriaApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.StrutturaContoApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.StrutturaInfoApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.StrutturaWelfareServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.TipoUtenzaApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.business.be.impl.VerificaImpresaApiServiceImpl;
import it.csi.gescovid.gestruttureresapi.util.SpringInjectorInterceptor;
import it.csi.gescovid.gestruttureresapi.util.SpringSupportedResource;


@ApplicationPath("restfacade/be")
public class GeststruttureresapiRestApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<>();

	public GeststruttureresapiRestApplication() {
		
		configureSwagger();

		singletons.add(new DecorsoApiServiceImpl());
		singletons.add(new SoggettiApiServiceImpl());
		singletons.add(new EnteApiServiceImpl());
		singletons.add(new TipoUtenzaApiServiceImpl());
		singletons.add(new AssistenzaMedicaApiServiceImpl());
		singletons.add(new StrutturaInfoApiServiceImpl());
		singletons.add(new RsaStrutturaNoteApiServiceImpl());
		singletons.add(new RsaPostiApiServiceImpl());
		singletons.add(new RsaPersonaleApiServiceImpl());
		singletons.add(new RsaTamponeApiServiceImpl());
		singletons.add(new RsaOspitiApiServiceImpl());
		singletons.add(new RsaDecessiApiServiceImpl());
		singletons.add(new RsaTipoTamponeApiServiceImpl());
		singletons.add(new RsaPersonaleTipoApiServiceImpl());
		singletons.add(new RsaTamponeCategoriaApiServiceImpl());
		singletons.add(new StrutturaCategoriaApiServiceImpl());
		singletons.add(new RsaVisitatoriApiServiceImpl());
        singletons.add(new RsaVisitatoriIngressiApiServiceImpl());
        singletons.add(new StrutturaWelfareServiceImpl());
        singletons.add(new VerificaImpresaApiServiceImpl());
        singletons.add(new DecodificaApiServiceImpl());
        singletons.add(new RendicontazioneApiServiceImpl());
        singletons.add(new RichiestaTamponeApiServiceImpl());
        singletons.add(new RendicontazioneBandiApiServiceImpl());
        singletons.add(new FileApiServiceImpl());
        
        singletons.add(new MovimentoOspiteApiServiceImpl());
        singletons.add(new StrutturaContoApiServiceImpl());
        singletons.add(new SpringInjectorInterceptor());
        singletons.add(new MovimentoApiServiceImpl());
        singletons.add(new RichiesteIntegrazioneBandiApiServiceImpl());
		
		
		for (Object c : singletons) {
			if (c instanceof SpringSupportedResource) {
				SpringApplicationContextHelper.registerRestEasyController(c);
			}
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	
	private void configureSwagger() {

		classes.add(ApiListingResource.class);
		classes.add(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("gest-struttureres-api");
        config.setTitle("Interventi e diari pazienti");
        config.setVersion("v1");
        config.setContact("CSI Piemonte");
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath("/restfacade/be");
        config.setResourcePackage("it.csi.gescovid.gestruttureresapi.business.be");
        config.setDescription("API dell'applicazione gestruttureres");
        config.setPrettyPrint(true);
        config.setScan(true);
    }

}
