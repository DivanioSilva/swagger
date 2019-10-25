package com.ds.swagger.client;

import com.ds.swagger.dto.PersonDTO;
import com.ds.swagger.dto.ResponseBodyVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component
public class ServiceInvoker {
    private static final Logger LOGGER = Logger.getLogger( ServiceInvoker.class.getName() );

    @Value("${com.ds.test}")
    private String uri;

    private final RestTemplate restTemplate;

    public ServiceInvoker(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void callExternalService(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        //Foo foo = restTemplate.postForObject(fooResourceUrl, request, Foo.class);
        String message = String.format("Calling %s", uri);
        LOGGER.info(message);

        PersonDTO dto = new PersonDTO();
        dto.setCity("Lisbon");
        dto.setAge(22);
        dto.setName("Divanio Silva");
        dto.setToday(new Date());


        PersonDTO answer = restTemplate.postForObject(uri, dto, PersonDTO.class);
        System.out.println(answer);

        /**

        String url = "endpoint url";
        String requestJson = "{\"queriedQuestion\":\"Is there pain in your hand?\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);

         */
    }

    public void findAllUsers(){
        ResponseEntity<List<PersonDTO>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PersonDTO>>(){});
        List<PersonDTO> persons = response.getBody();

        persons.forEach(System.out::println);

        System.out.println();
    }
}
