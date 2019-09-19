package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Revisit;
import entity.Client;
import service.RevisitService;
import service.ClientService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Revisit")
public class RevisitController {

	@Autowired
	RevisitService revisitService;
	@Autowired
	ClientService clientService;
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit) {
		ReturnInfo info = new ReturnInfo();
		String where="";
		if(txt!=null) where=" where c_client.name like '%"+txt+"%'";
		String lim = info.getLimit(page, limit);
		info.setCount(revisitService.selectCount(where));
		info.setList(revisitService.getAll(where,lim));
		return info;
	}
	
	@RequestMapping("getLinkstatus")
	public @ResponseBody String[] getLinkstatus() {
		return Revisit.linkstatus;
	}
	@RequestMapping("getClientstatus")
	public @ResponseBody String[] getClientstatus() {
		return Revisit.clientstatus;
	}
	@RequestMapping("getPurposestatus")
	public @ResponseBody String[] getPurposestatus() {
		return Revisit.purposestatus;
	}
	@RequestMapping("getAssessstatus")
	public @ResponseBody String[] getAssessstatus() {
		return Revisit.assessstatus;
	}
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus() {
		return Revisit.execstatus;
	}
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Revisit.status;
	}
	
	@RequestMapping("getClients")
	public @ResponseBody List<Client> getClients() {
		return clientService.getAll(null,null);
	}
	
	
	@RequestMapping("delete")
	public @ResponseBody String delete(int id) {
		revisitService.delete(id);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("insert")
	public @ResponseBody String insert(Revisit u) {
		revisitService.insert(u);
		return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	public @ResponseBody Revisit edit(int id) {
		return revisitService.getById(id);
	}
	@RequestMapping("update")
	public @ResponseBody String update(Revisit u) {
		revisitService.update(u);
		return "{\"status\":1}";
	}
}
