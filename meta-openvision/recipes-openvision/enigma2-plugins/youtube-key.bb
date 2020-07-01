DESCRIPTION = "YouTube key for enigma2 plugins"
LICENSE = "CLOSED"

inherit allarch

SRC_URI = "file://YouTube.key"

CONFFILES = "${sysconfdir}/enigma2/YouTube.key"

do_install_append() {
	install -d ${D}${sysconfdir}/enigma2
	install -m 0644 ${WORKDIR}/YouTube.key ${D}${sysconfdir}/enigma2/YouTube.key
}
