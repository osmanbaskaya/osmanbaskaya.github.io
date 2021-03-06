---
layout: post
comments: true
title:  "Struggles of Journalism in Turkey"
excerpt: In this work, we created a graph using Graph Commons in order to visualize job status of journalists. Current state of free speech for media in Turkey is quite problematic. A lot of media workers are pushing to quit from their job or fired because of their recent works.
---

## Media as a Puppet

> If I'd written all the truth I knew for the past ten years, about 600 people - including me - would be rotting in prison cells from Rio to Seattle today. Absolute truth is a very rare and dangerous commodity in the context of professional journalism. ― Hunter S. Thompson

Unfortunately, writing what is really happening is always a brave job. In Turkey, it's getting harder and harder in everyday. Couple of months ago, [Graph Commons](http://graphcommons.com) organized an hackathon ([Structured Journalism and Network Mapping Hackathon](http://graphcommons.github.io/hackathons/2015/08/21/istanbul-yapisal-gazetecilik-en/)) related with current problems in Turkey. Topics were totally interesting, and I attended the hackathon with my brother who is a graduate student in Economy. It was a lot of fun; I met with a lot of people with different backgrounds: activists, journalists, directors, and so on. These kind of events are especially valuable for me because, as a Computer Engineer, it is not always easy for me to come across people who have diverse backgrounds. 

## What is Graph Commons?

Graph Common provides you a platform that you can easily build and visualize your graph with plenty of features such as filtering, graph coloring, path finding and so on. People in Graph Commons try to help you to reveal the hidden patterns and penetrate the data more easily by graph representation and valuable features they implemented.

## First Iteration

<iframe src="https://graphcommons.com/graphs/eeca1241-1a2c-4c6e-88a3-b52999645284/embed?auto=false" frameborder="0" style="overflow:hidden;width:840px;min-width:600px;border:1px solid #DDDDDD;;height:560px;min-height:400px;" width="840" height="560" allowfullscreen></iframe>

Although there were other interesting topics, we (Kerem, Mohan and I) focussed on journalism. Media is under pressure perhaps as never before. Couple of years ago, phone tapes were leaked to the public. The topics in the tapes were diverse. Some of them are related with media. In those phone tapes there were very important political actors and media owners discussing about what would have been cencored and what should have been done against journalists who published "disturbing" news. The main reason why decent journalists are in danger is illustrated in [this graph](http://mulksuzlestirme.org/turkey-media-ownership-network/). Media owners are not only media owners; they are also running business in construction and energy sector (Sidenote: I am particularly curious to verify if there is a correlation between media corruption and active construction and energy sectors in a country.) As you imagened, those media workers were pushed to be resigned, or fired with some pretext. In this work, we tried to illustrate media workers, their previous job and their current/next job if s/he has. Otherwise, we are creating an edge from old journal to `unemployed` node. 

We collected the data various newspapers. We also used `Diminishing Press Freedom in Turkey` (by Turkey Task Force, November 2014). You can find the book [here](https://dl.dropboxusercontent.com/u/3482709/books/Diminishing-Press-Freedom-in-Turkey-Turkey-Task-Force.pdf).

## What is next?

This graph is starting point for deeper analysis. Next step would be adding the last subject that each journalists worked on. In order to do this, it might be necessary to get help from professional journalists since the graph contains not only reporters but also higher rank professionals such as editors-in-chief. Thus, it would be hard to find out what is the "real" reason behind the scene of firing/quitting.


## How to contribute?

There are various ways to contribute this project.

1. All the data is open. You can reach it via [this link](https://goo.gl/sxcdqL). There might be error in records, update needs to be done, or you may want to add another media worker. You can leave comment for these issues. I would like to explain the format we follow in this document: Each row represents the work changes. `From Where` is the former journal. Time represents the date when the journalist has no longer work in the former journal. `Source` columns denote the source of this action. `Reason` part is not important for now. However, if you think that the reason for this action (from moving one journal to another (or unemployment) is obvious, you can note it and write down your sources for the reason, too. 
2. If you think that project is interesing, we will be happy if you join our work. I can give you necessary information such as API key, andedit priviledge for the data sheet.
3. You can share your ideas to improve the graph. We have [slack group](https://graphcommons.slack.com/messages/media-workers/). But first you have to sign-up. Here is the [link](http://graphcommons-slack.herokuapp.com/).
4. We have a [github repo](https://github.com/osmanbaskaya/journalist-firing-in-turkey). After discussing what you want to add or analysis, you can send me pull request.
