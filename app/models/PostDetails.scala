package models

import play.api.data.Form
import play.api.data.Forms.mapping

case class PostDetails( post :String )

object PostDetails
{
  val postForm :Form[PostDetails] = Form(
    mapping(
      "post" -> nonEmptyText
    )(PostDetails.apply)(PostDetails.unapply)
  )
}