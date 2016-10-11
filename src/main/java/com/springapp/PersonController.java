package com.springapp;
/*
 Веб-приложение по управлению новостной лентой на сайте.
		 Каждая новость состоит из названия, содержания, даты публикации и категории,к которой относится новость.

		 Каждая категория содержит название, и к ней может быть привязано несколько новостей.

		 Приложение должно предоставляет следующие возможности по работе с новостями:
		 - просматривать список новостей
		 - поиск новости по категории (возможность выбрать из существующих категорий),названию и содержанию
		 - создание и редактирование новости
		 - удаление новости
*/
import com.springapp.model.Selector;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.springapp.service.NewsService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("selector")
public class PersonController {

	private NewsService newsService;

	@Autowired(required=true)
	@Qualifier(value="newsService")
	public void setNewsService(NewsService ps){
		this.newsService = ps;
	}

	@ModelAttribute("selector")
	public Selector getUserObject() {
		return new Selector();
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( HttpSession httpSession ) {

		httpSession.setAttribute("selector", new Selector() );
		return "news";
	}




	@RequestMapping(value = "/newses", method = RequestMethod.GET)
	public String listNews( @ModelAttribute Selector selector,Model model) {
		model.addAttribute("news", new com.springapp.model.News());

	if (selector.getTitle()!=null)
		model.addAttribute("listNews", this.newsService.selectNewsByTitle(selector.getTitle()));
		if (selector.getContent()!=null)
		model.addAttribute("listNews", this.newsService.selectNewsByContent(selector.getContent()));
		if (selector.getCategory()!=null)
		model.addAttribute("listNews", this.newsService.selectNewsByCategory(selector.getCategory()));
	else
	{model.addAttribute("listNews", this.newsService.listNews());}
		selector.setTitle(null);
		selector.setContent(null);
		selector.setCategory(null);

		model.addAttribute("selector", selector);
		return "news";
	}


//фильтр
	@RequestMapping(value= "/newses/select", method = RequestMethod.POST)
	public String selectNews(@ModelAttribute("selector") com.springapp.model.Selector selector,Model model) {

		model.addAttribute("selector", selector);
			return "redirect:/newses";
		}


	@RequestMapping(value= "/newses/add", method = RequestMethod.POST)
	public String addNews(@ModelAttribute("news") com.springapp.model.News p){

	if(p.getId() == 0){
			//new person, add it
			this.newsService.addNews(p);}
	else{
			//existing person, call update
			this.newsService.updateNews(p);
	}

		return "redirect:/newses";
}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping("/remove/{id}")
   public String removeNews(@PathVariable("id") int id){

       this.newsService.removeNews(id);
       return "redirect:/newses";
  }

    @RequestMapping("/edit/{id}")
   public String editNews(@PathVariable("id") int id, Model model){
     model.addAttribute("news", this.newsService.getNewsById(id));
      model.addAttribute("listNews", this.newsService.listNews());
       return "news";
   }




}
