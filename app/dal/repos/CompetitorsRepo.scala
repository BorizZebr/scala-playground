package dal.repos

import javax.inject.{Inject, Singleton}

import dal.components.{CrudComponent, DatabaseComponent}
import models.Competitor
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

/**
  * Created by borisbondarenko on 26.05.16.
  */
@Singleton()
class CompetitorsRepo @Inject() (val dbConfig: DatabaseConfig[JdbcProfile])
  extends DatabaseComponent
  with CrudComponent {

  import driver.api._

  class CompetitorsTable(tag: Tag) extends Table[Competitor](tag, "COMPETITOR")
    with IdColumn[Competitor] {

    def name = column[String]("NAME")
    def url = column[String]("URL")
    override def * = (id.?, name, url) <>(Competitor.tupled, Competitor.unapply)
  }

  override type Entity = Competitor
  override type EntityTable = CompetitorsTable
  override val table = TableQuery[CompetitorsTable]
}