package kz.kaznitu.springrest;

import com.springapp.mvc.models.Country;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List getCountries(){
        List<Country> listOfCountries = new ArrayList<Country>() ;
        listOfCountries = createCountries() ;
        return listOfCountries ;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
    public Country getCountryById(@PathVariable int id){
        List<Country> listOfCountries = new ArrayList<Country>() ;
        listOfCountries = createCountries() ;
        for(Country country : listOfCountries)
            if (country.getId() == id){
                return country ;
            }
        return null ;
    }

    public List<Country> createCountries(){
        Country kazakCountry = new Country(1, "Kazakhstan") ;
        Country indiaCountry = new Country(2, "India") ;
        Country chinaCountry = new Country(3, "China") ;
        Country nepalCountry = new Country(4, "Nepal") ;
        Country bhutanCountry = new Country(5, "Bhutan") ;

        List<Country> listOfCountries = new ArrayList<Country>() ;
        listOfCountries.add(kazakCountry) ;
        listOfCountries.add(indiaCountry) ;
        listOfCountries.add(chinaCountry) ;
        listOfCountries.add(nepalCountry) ;
        listOfCountries.add(bhutanCountry) ;

        return listOfCountries ;
    }
}
