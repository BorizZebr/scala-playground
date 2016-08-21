package controllers

import javax.inject.Inject

import dal.repos._
import models.ResponseTemplate
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by borisbondarenko on 22.08.16.
  */
class ResponseTemplates @Inject()
    (respTemplatesRepo: RespTemplatesDao) extends Controller {

  /**
    * Templates page controller
    */
  def templates = Action {
    Ok(views.html.templates())
  }

  def getTemplates = Action.async{
    respTemplatesRepo.getAll.map { rs =>
      Ok(Json.toJson(rs))
    }
  }

  def updateTemplate() = Action.async { request =>
    val json = request.body.asJson.get
    val resTemp = json.as[ResponseTemplate]

    respTemplatesRepo.update(resTemp).map { _ =>
      Ok
    }
  }

  def createTemplate = Action.async { request =>
    val json = request.body.asJson.get
    val resTemp = json.as[ResponseTemplate]

    respTemplatesRepo.insert(resTemp).map { _ =>
      Ok
    }
  }

  def deleteTemplate(id: Long) = Action.async {
    respTemplatesRepo.delete(id).map { _ =>
      Ok
    }
  }
}