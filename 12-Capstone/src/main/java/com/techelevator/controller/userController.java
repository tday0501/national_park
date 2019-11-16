package com.techelevator.controller;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.techelevator.model.parks.Park;
import com.techelevator.model.parks.ParksDAO;
import com.techelevator.model.survey.Survey;
import com.techelevator.model.survey.SurveyDAO;
import com.techelevator.model.weather.Weather;
import com.techelevator.model.weather.WeatherDAO;

@Controller
public class userController {

	@Autowired
	private ParksDAO parkDao;
	
	@Autowired
	private WeatherDAO weatherDao;

	@Autowired
	private SurveyDAO surveyDao;
	
	@GetMapping(path= {"/", "home"})
	public String showHomePage(ModelMap modelMap){
		modelMap.put("parks", parkDao.getAllParks());
		return "homepage";
	}
	
	@PostMapping("/parkDetailsPage")
	public String showConversionPage( @RequestParam String temperature,@RequestParam String id, HttpSession session)  {
		session.setAttribute("temperature", temperature);
	return "redirect:/parkDetails?id=" + id;
	}
	
	@GetMapping("/survey")
	public String showSurveyPage(ModelMap modelMap){
		if (modelMap.containsAttribute("formData") == false) {
			Survey empty = new Survey();
			modelMap.put("formData", empty);
		}
		Survey survey = new Survey();
		modelMap.put("parks", parkDao.getAllParks());
		modelMap.put("states", survey.getStates());
		modelMap.put("options", survey.getOptions());
		return "survey";
	}
	
	@GetMapping("/parkDetails")
	public String showDetailsPage(@RequestParam String id, ModelMap modelMap){
		modelMap.put("item", parkDao.getParkByCode(id));
		modelMap.put("weathers", weatherDao.getWeather(id));
		return "parkDetailsPage";
	}
	
	@PostMapping("/submitSurvey")
	public String postSurvery(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes ra){
		if(result.hasErrors()) {
			ra.addFlashAttribute("formData", survey);
			ra.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "formData", result);
			return "redirect:/survey";
		}
		surveyDao.save(survey);
		return "redirect:favoritePage";
	}
	
	@GetMapping("/favoritePage")
	public String showFavorites(ModelMap modelMap) {
		modelMap.put("formResults", surveyDao.getSurveyResponses());
		return "favoritesPage";
	}
	
}
