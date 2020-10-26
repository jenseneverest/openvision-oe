DESCRIPTION = "meta package for usbserial drivers"
RDEPENDS_${PN} = "kernel-module-usbserial kernel-module-ftdi-sio kernel-module-pl2303 kernel-module-belkin-sa kernel-module-keyspan"

require conf/license/openvision-gplv2.inc

ALLOW_EMPTY_${PN} = "1"
