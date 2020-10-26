DESCRIPTION = "USB serial drivers"

require conf/license/openvision-gplv2.inc

RDEPENDS_${PN} = "kernel-module-usbserial kernel-module-ftdi-sio kernel-module-pl2303 kernel-module-belkin-sa kernel-module-keyspan"

ALLOW_EMPTY_${PN} = "1"
