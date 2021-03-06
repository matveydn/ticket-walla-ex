package com.ticketwala.command.impl;

import java.util.List;

import com.ticketwala.command.api.Command;
import com.ticketwala.command.api.Result;
import com.ticketwala.model.MovieShow;
import com.ticketwala.service.api.TicketWalaService;

public class PrintAllMovieShowsCommand extends Command {

	public PrintAllMovieShowsCommand(Object commandInput, TicketWalaService tws) {
		super(commandInput, tws);
	}

	@Override
	public Result execute() {
		List<MovieShow> ms = this.ticketWalaService.getMovieShows();
		if (ms != null)	{
			return new Result(true, ms.toString());
		} else {
			return new Result(false, "No Movie Shows found!");
		}
	}

}
