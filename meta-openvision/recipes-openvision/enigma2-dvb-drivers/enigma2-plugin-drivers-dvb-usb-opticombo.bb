DESCRIPTION = "USB DVB Driver for OPTI-Combo Tuner"

require conf/license/license-gplv2.inc

inherit allarch
PACKAGES = "${PN}"

RRECOMMENDS_${PN} = " \
	kernel-module-dvb-usb-dvbsky \
	kernel-module-dvb-usb-v2 \
	kernel-module-m88ds3103 \
	kernel-module-si2168 \
	kernel-module-si2157 \
	firmware-dvb-demod-si2168-b40 \
	firmware-dvb-demod-si2168-a20 \
	firmware-dvb-demod-si2168-a30 \
	firmware-dvb-tuner-si2158-a20 \
	"

ALLOW_EMPTY_${PN} = "1"
