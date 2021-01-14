require linux-libc-headers-old.inc

SRC_URI[md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"

SRC_URI += "file://linuxdvb.patch \
	file://ppp.patch \
	file://types.patch \
	"
