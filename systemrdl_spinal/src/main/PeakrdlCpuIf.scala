package systemrdl_spinal

import spinal.core._
import spinal.lib._

case class PeakrdlCpuIf(
  addr_width: Int, data_width: Int
) extends Bundle with IMasterSlave {
  val req = Bool()
  val req_is_wr = Bool()
  val addr = Bits(addr_width bits)
  val wr_data = Bits(data_width bits)
  val wr_biten = Bits(data_width bits)
  val req_stall_wr = Bool()
  val req_stall_rd = Bool()
  val rd_ack = Bool()
  val rd_err = Bool()
  val rd_data = Bits(data_width bits)
  val wr_ack = Bool()
  val wr_err = Bool()

  override def asMaster(): Unit = {
    out(req, req_is_wr, addr, wr_data, wr_biten)
    in(req_stall_wr, req_stall_rd, rd_ack, rd_err, rd_data, wr_ack, wr_err)
  }
}
