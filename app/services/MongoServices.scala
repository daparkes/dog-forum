package services

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import javax.inject.Inject
import models.{Feed, PostDetails, User}
import play.modules.reactivemongo.{ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.api.commands.WriteResult
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.Future

class MongoServices @Inject()(
                               val reactiveMongoApi: ReactiveMongoApi
                             ) extends ReactiveMongoComponents {

  def collection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection[JSONCollection](""))

  def create(post: PostDetails): Future[WriteResult]
  val user = User(29, "John", "Smith", List(Feed("Slashdot news", "http://slashdot.org/slashdot.rdf")))
  val futureResult = collection.flatMap(_.insert.one(user))
  futureResult.map(_ => Ok("post created"))
}
