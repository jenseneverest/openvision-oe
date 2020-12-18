DESCRIPTION = "Open Vision permission helper"
SECTION = "base"
LICENSE = "CLOSED"

inherit update-rc.d

SRC_URI = "file://ov-permission-helper.sh"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/ov-permission-helper.sh ${D}${sysconfdir}/init.d/0000-ov-permission-helper.sh
}

FILES_${PN} = "${sysconfdir}"

INITSCRIPT_NAME = "0000-ov-permission-helper.sh"
INITSCRIPT_PARAMS = "start 05 S ."
